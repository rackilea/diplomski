Class<?> cls = new SimulatorClassloader().loadClass(this.simulatorGUI.getStageTitle());
                try {
                    Method method = cls.getMethod("main");
                    try {
                        method.invoke(cls.newInstance());
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }