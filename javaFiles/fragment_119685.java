Class<?> cls = new SimulatorClassloader().loadClass(this.simulatorGUI.getStageTitle());
                try {
                    Method method = cls.getMethod("main");
                    try {
                        Object obj = cls.newInstance();
                        method.invoke(obj);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }