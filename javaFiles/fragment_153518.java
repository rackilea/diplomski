//...
                        System.out.println(numberofbytesread);
                        sourcedataline.write(sounddata, 0, numberofbytesread);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {   //added
                 /*here it stops*/
            }             //added