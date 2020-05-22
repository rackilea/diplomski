for(int j = 0; j < ScanDataStructConstants.NUM_ROWS; j++)
                    {                           
                        if(!taskWorker.isCancelled())
                        {
                            float[] oneRow = scanDataArray.getOneRowDataFromAView(i, j);                              
                            dataBuffer.rewind();
                            FloatBuffer floatBuffer = dataBuffer.asFloatBuffer();
                            floatBuffer.put(oneRow);
                            bytesThisWritten = out.write(dataBuffer);
                            bytesWritten = bytesWritten + bytesThisWritten;
                            if(i == 0)
                            {
                                System.out.println("DataMgr write data i,j=" + i + "," + j + 
                                        ", bytesThisWritten=" + bytesThisWritten + 
                                        ", byteWritten=" + bytesWritten + 
                                        " oneRow.size=" + oneRow.length + 
                                        ", oneRow[0]" + oneRow[0]);
                            }                               
                        }
                        else
                        {
                            status = ReturnStatusEnum.CANCELED_FAILURE;
                            break;
                        }
                    }
                }