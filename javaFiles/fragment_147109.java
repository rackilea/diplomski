public static EObject createClassByName(String className) {

        EObject eObject = null;
        try {
            Registry registry = EPackage.Registry.INSTANCE;
            for (String key : new HashSet<String>(registry.keySet())) {
            EPackage ePackage = registry.getEPackage(key);
            if (ePackage.getClass().getName().startsWith("")) {
                for (EClassifier eClassifier : ePackage.getEClassifiers()) {
                if (eClassifier instanceof EClass) {
                    EClass eClass = (EClass) eClassifier;
                    if (eClass.getName().equals(className)) {
                    if (!eClass.isAbstract()) {
                        eObject = ePackage.getEFactoryInstance().create(eClass);
                    }
                    }
                }
                }
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eObject;
        }


 public static List<EClass> getAllClassesInheritFrom(String className) {
        List<EClass> eClasses = new ArrayList<EClass>();
        try {
            Registry registry = EPackage.Registry.INSTANCE;
            for (String key : new HashSet<String>(registry.keySet())) {
            EPackage ePackage = registry.getEPackage(key);
            if (ePackage.getClass().getName().startsWith("")) {
                for (EClassifier eClassifier : ePackage.getEClassifiers()) {
                if (eClassifier instanceof EClass) {
                    EClass eClass = (EClass) eClassifier;
                    if (eClass.getName().equals(className)) {
                    if (!eClass.isAbstract()) {
                        eClasses.add(eClass);

                    }
                    } else {
                    for (EClass bla : eClass.getEAllSuperTypes()) {
                        if (bla.getName().equals(className)) {
                        if (!eClass.isAbstract()) {
                            eClasses.add(eClass);
                        }
                        }
                    }
                    }
                }
                }
            }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return eClasses;
        }