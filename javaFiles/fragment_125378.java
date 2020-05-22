while (true) {
            {
                accessLock.lock();
                if(CanContinue == false)
                    condition.await();
                try {
        //            WaitForConnection();
                    GetStreams();
                    ProcessConnection();
                accessLock.unlock();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "ارتباط قطع شد" + e.getMessage());


                }
            }
        }