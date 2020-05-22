public void printBillToDevice(final String address) {
            mBTAdapter.cancelDiscovery();
            try {           BluetoothDevice mdevice = mBTAdapter.getRemoteDevice(address);
                Method m = mdevice.getClass().getMethod("createRfcommSocket",
                        new Class[] { int.class });
                mBTSocket = (BluetoothSocket) m.invoke(mdevice, 1);
                mBTSocket.connect();

                //this will do the code
                int copyPrintIs = Integer.parseInt(copyPrint);
                for (int x = 1; x <= copyPrintIs; x++) {
                    OutputStream os = mBTSocket.getOutputStream();
                    os.flush();
                    os.write(BILL.getBytes());
                    System.out.println(BILL);
                    SystemClock.sleep(4000);//This will pause every 4 seconds after printing once and the continue and pause again  
                }
                copyPrint = "1";//This will change the copyPrint back to 1 value

                if (mBTAdapter != null)
                    mBTAdapter.cancelDiscovery();
                mBTSocket.close();
                setResult(RESULT_OK);
            } catch (Exception e) {
                Log.e("Class ", "My Exe ", e);
                // Toast.makeText(BluetoothPrint.this, ERROR_MESSAGE,
                // Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                setResult(RESULT_CANCELED);
            }
        }