int oldSensorValue1 = 0;
int oldSensorValue2 = 0;
int oldSensorValue3 = 0;
for (int i = 0; ; i++) {

    // Get the data from analog input 5
    int sensorValue1 = phidget.getSensorValue(1);
    int sensorValue2 = phidget.getSensorValue(2);
    int sensorValue3 = phidget.getSensorValue(3);

        if (sensorValue1 > 100 && oldSensorValue1 < 100){

            System.out.println("RIGHT");

            // simulates RIGHT key
            try { 
            Robot robot = new Robot(); 
            robot.keyPress(KeyEvent.VK_RIGHT); 
            } catch (AWTException e) { 
            e.printStackTrace(); 
            }

        } else if (sensorValue2 > 100 && oldSensorValue2 < 100)
        {
            System.out.println("LEFT");

            // simulates LEFT key
            try { 
            Robot robot = new Robot(); 
            robot.keyPress(KeyEvent.VK_LEFT); 
            } catch (AWTException e) { 
            e.printStackTrace(); 
            }
        } else if (sensorValue3 > 100 && oldSensorValue3 < 100)
        {
            System.out.println("ENTER");

            // simulates RIGHT key
            try { 
            Robot robot = new Robot(); 
            robot.keyPress(KeyEvent.VK_RIGHT); 
            } catch (AWTException e) { 
            e.printStackTrace(); 
            }
        }
        oldSensorValue1 = sensorValue1;
        oldSensorValue2 = sensorValue2;
        oldSensorValue3 = sensorValue3;
}