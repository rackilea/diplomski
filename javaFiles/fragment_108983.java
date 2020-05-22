if (samples_acc < samples_total || samples_gyro < samples_total || samples_rotation < samples_total) 
                {
                            if (flag == true) 
                            {

                                //Get current date and time
                                currentTime = Calendar.getInstance().getTime();
                                dateTime = currentTime.toString();

                                //Add x,y,z values to arrays for sensors

                                if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER && samples_acc < samples_total) 
                                {
                                accDoubleArrayX[samples_acc] = x;
                                accDoubleArrayY[samples_acc] = y;
                                accDoubleArrayZ[samples_acc] = z;

                                samples_acc++;
                                }

                                if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE && samples_gyro < samples_total) 
                                {
                                gyroDoubleArrayX[samples_gyro] = x2;
                                gyroDoubleArrayY[samples_gyro] = y2;
                                gyroDoubleArrayZ[samples_gyro] = z2;

                                samples_gyro++;
                                }

                                if (sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR && samples_rotation < samples_total) 
                                {
                                rotationDoubleArrayX[samples_rotation] = x3;
                                rotationDoubleArrayY[samples_rotation] = y3;
                                rotationDoubleArrayZ[samples_rotation] = z3;
                                rotationDoubleArrayCos[samples_rotation] = cos3;
                                rotationDoubleArrayAccuracy[samples_rotation] = accuracy3;

                                samples_rotation++;
                                }

                            }//end if flag=true
                            else 
                            {
                            //Log.d("", "samples < total but Flag is false - Data NOT inserted");
                            }
            }//end if at least one of arrays is not filled yet

            //all arrays have been filled   
            else 
            {
                durationTime = System.currentTimeMillis() - startTime;

                //Insert x,y,z values for sensors
                dbRef.insertData(dateTime, accDoubleArrayX, accDoubleArrayY, accDoubleArrayZ,
                        gyroDoubleArrayX, gyroDoubleArrayY, gyroDoubleArrayZ,
                        rotationDoubleArrayX, rotationDoubleArrayY, rotationDoubleArrayZ, rotationDoubleArrayCos, rotationDoubleArrayAccuracy,
                        durationTime, label);

                Log.d("", "Data inserted!");
                Toast.makeText(this, "Data inserted!", Toast.LENGTH_LONG).show();

                //Stop recording when given number of samples inserted
                flag = false;
            }