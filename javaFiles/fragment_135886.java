if (e == null) {
                    try {
                        aF = query.find();
                    } catch (com.parse.ParseException e1) {
                        e1.printStackTrace();
                        return; //<-- add this, and if you wish, an eror message
                    }
                    Toast.makeText(getActivity(), "Success",
                            Toast.LENGTH_LONG).show();
                } else {
                    Log.d("Error", e.toString());
                }