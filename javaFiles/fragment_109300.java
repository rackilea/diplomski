Collections.sort(arrlst,new Comparator<T>() {

                    public int compare(T lhs, T rhs) {

                        try {
                            SimpleDateFormat dateFormatlhs = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                            Date convertedDatelhs = dateFormatlhs.parse(lhs.feedCreatedTime);
                            Calendar calendarlhs = Calendar.getInstance();
                            calendarlhs.setTime(convertedDatelhs);

                            SimpleDateFormat dateFormatrhs = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                            Date convertedDaterhs = dateFormatrhs.parse(rhs.feedCreatedTime);
                            Calendar calendarrhs = Calendar.getInstance();
                            calendarrhs.setTime(convertedDaterhs);

                            if(calendarlhs.getTimeInMillis() > calendarrhs.getTimeInMillis())
                            {   


                                return -1;
                            }
                            else
                            {


                                return 1;

                            }
                        } catch (ParseException e) {

                            e.printStackTrace();
                        }


                        return 0;
                    }
                });