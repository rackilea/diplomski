project adalib is
    for Languages use ("Ada");
    for Source_Dirs use (project'Project_Dir & "./src");
    for Library_Kind use "dynamic"; -- for DLL
    for Library_Name use project'Name; -- will produce "libadalib.dll"
    for Library_Interface use ("ada_interface");
    for Library_Dir use project'Project_Dir & "./dll";
    for Library_Src_Dir use project'Project_Dir & "./dll";
    -- include other DLL / .a here if needed
    -- for Library_Options use ("-L" & path_to_lib,
    --                          "-l" & path_to_lib  
    --                         );
    -- define your favorite compiler, builder, binder, linker options
end adalib;