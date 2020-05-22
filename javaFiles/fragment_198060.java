if("001".equals(id)){
                            // Launch Admin Activity
                            Intent tab1 = new Intent(getApplicationContext(), AdminActivity.class);                     
                                // Close all views before launching requestActivity
                            tab1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(tab1);
                            return;
                        }