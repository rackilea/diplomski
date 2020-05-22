public class AsposeJavaModuleBuilder extends ModuleBuilder implements SourcePathsBuilder {

private Project myProject;
ResourceBundle bundle = ResourceBundle.getBundle("Bundle");

@Override
public String getBuilderId() {
    return getClass().getName();
}

@Override
public String getPresentableName() {
    return "Aspose Application";
}

@Override
public String getDescription() {
    return bundle.getString("AsposeWizardPanel.myMainPanel.description");


}

@Override
public Icon getBigIcon() {
    return AsposeIcons.AsposeMedium;
}

@Override
public Icon getNodeIcon() {
    return AsposeIcons.AsposeLogo;
}


@Override
public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
    return new ModuleWizardStep[]{
            new AsposeAPIsWizardStep(this, wizardContext),
    };
}


@Override
public void setupRootModel(ModifiableRootModel rootModel) throws com.intellij.openapi.options.ConfigurationException {



    setMyProject(rootModel.getProject());
    final CompilerModuleExtension compilerModuleExtension = rootModel.getModuleExtension(CompilerModuleExtension.class);
    compilerModuleExtension.setExcludeOutput(true);

    if (myJdk != null) {
        rootModel.setSdk(myJdk);
    } else {
        rootModel.inheritSdk();
    }

    ContentEntry contentEntry = doAddContentEntry(rootModel);
    if (contentEntry != null) {
        final List<Pair<String, String>> sourcePaths = getSourcePaths();

        if (sourcePaths != null) {
            for (final Pair<String, String> sourcePath : sourcePaths) {
                String first = sourcePath.first;
                new File(first).mkdirs();
                final VirtualFile sourceRoot = LocalFileSystem.getInstance()
                        .refreshAndFindFileByPath(FileUtil.toSystemIndependentName(first));
                if (sourceRoot != null) {
                    contentEntry.addSourceFolder(sourceRoot, false, sourcePath.second);
                }
            }
        }
    }

    if (myCompilerOutputPath != null) {
        // should set only absolute paths
        String canonicalPath;
        try {
            canonicalPath = FileUtil.resolveShortWindowsName(myCompilerOutputPath);
        } catch (IOException e) {
            canonicalPath = myCompilerOutputPath;
        }
        compilerModuleExtension
                .setCompilerOutputPath(VfsUtil.pathToUrl(FileUtil.toSystemIndependentName(canonicalPath)));
    } else {
        compilerModuleExtension.inheritCompilerOutputPath(true);
    }

    LibraryTable libraryTable = rootModel.getModuleLibraryTable();
    for (Pair<String, String> libInfo : myModuleLibraries) {
        final String moduleLibraryPath = libInfo.first;
        final String sourceLibraryPath = libInfo.second;
        Library library = libraryTable.createLibrary();
        Library.ModifiableModel modifiableModel = library.getModifiableModel();
        modifiableModel.addRoot(getUrlByPath(moduleLibraryPath), OrderRootType.CLASSES);
        if (sourceLibraryPath != null) {
            modifiableModel.addRoot(getUrlByPath(sourceLibraryPath), OrderRootType.SOURCES);
        }
        modifiableModel.commit();
    }
    RunnableHelper.runWhenInitialized(getMyProject(), new Runnable() {
        public void run() {
            System.out.println("Hello I came here");
            final LibraryTablesRegistrar libTablesRegistrar = LibraryTablesRegistrar.getInstance();

            final LibraryTable libraryTable = libTablesRegistrar.getLibraryTable(getMyProject());

            final LibraryTable.ModifiableModel libTableModel = libraryTable.getModifiableModel();


            Library library = libTableModel.createLibrary(AsposeConstants.LIBRARY_NAME);
            libTableModel.commit();

            @NonNls final String path = getContentEntryPath() + File.separator + AsposeConstants.LIB_FOLDER;
            new File(path).mkdirs();


            for (AsposeJavaAPI api : AsposeProject.getApiList().values()) {
                System.out.println("Hello I came here2");
                if (api.is_selected()) {
                    try {
                        System.out.println("Hello I came here3");
                        AsposeAPIsManager.copyDirectory(AsposeAPIsManager.getLibaryDownloadPath() + api.get_name().toLowerCase(), path + File.separator + api.get_name());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String[] children = new File(path + File.separator + api.get_name().toLowerCase() + File.separator).list();
                    for (String _child : children) {
                        String jarPath = "jar://" + path + File.separator + api.get_name() + File.separator + _child + "!/";

                        Library.ModifiableModel model = library.getModifiableModel();

                        model.addRoot(jarPath, OrderRootType.CLASSES);

                        model.commit();

                    }
                }
            }


            Collection<Module> modules = ModuleUtil.getModulesOfType(getMyProject(), StdModuleTypes.JAVA);
            Iterator itr = modules.iterator();
            Module module = null;
            while (itr.hasNext()) {
                module = (Module) itr.next();
                break;
            }
            final ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(module);

            final ModifiableRootModel moduleRootModel = moduleRootManager.getModifiableModel();

            final Library lib = libraryTable.getLibraryByName(AsposeConstants.LIBRARY_NAME);

            if (moduleRootModel.findLibraryOrderEntry(lib) == null) {

                moduleRootModel.addLibraryEntry(lib);

            }
            moduleRootModel.commit();


        }
    });
}

@Override
public String getGroupName() {
    return JavaModuleType.JAVA_GROUP;
}

public Project getMyProject() {
    return myProject;
}

public void setMyProject(Project myProject) {
    this.myProject = myProject;
}

@Nullable
public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
    AsposeIntroWizardStep step = new AsposeIntroWizardStep();
    Disposer.register(parentDisposable, step);
    return step;
}


private String myCompilerOutputPath;
// Pair<Source Path, Package Prefix>
private List<Pair<String, String>> mySourcePaths;
// Pair<Library path, Source path>
private final List<Pair<String, String>> myModuleLibraries = new ArrayList<Pair<String, String>>();

public final void setCompilerOutputPath(String compilerOutputPath) {
    myCompilerOutputPath = acceptParameter(compilerOutputPath);
}

public List<Pair<String, String>> getSourcePaths() {
    if (mySourcePaths == null) {
        final List<Pair<String, String>> paths = new ArrayList<Pair<String, String>>();
        @NonNls final String path = getContentEntryPath() + File.separator + "src";
        new File(path).mkdirs();
        paths.add(Pair.create(path, ""));
        return paths;
    }
    return mySourcePaths;
}

public void setSourcePaths(List<Pair<String, String>> sourcePaths) {
    mySourcePaths = sourcePaths != null ? new ArrayList<Pair<String, String>>(sourcePaths) : null;
}

public void addSourcePath(Pair<String, String> sourcePathInfo) {
    if (mySourcePaths == null) {
        mySourcePaths = new ArrayList<Pair<String, String>>();
    }
    mySourcePaths.add(sourcePathInfo);
}

public ModuleType getModuleType() {
    return StdModuleTypes.JAVA;
}

@Override
public boolean isSuitableSdkType(SdkTypeId sdkType) {
    return sdkType instanceof JavaSdkType;
}

@Nullable
@Override
public ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep) {
    return StdModuleTypes.JAVA.modifySettingsStep(settingsStep, this);
}

private static String getUrlByPath(final String path) {
    return VfsUtil.getUrlForLibraryRoot(new File(path));
}

public void addModuleLibrary(String moduleLibraryPath, String sourcePath) {
    myModuleLibraries.add(Pair.create(moduleLibraryPath, sourcePath));
}

@Nullable
protected static String getPathForOutputPathStep() {
    return null;
}
}