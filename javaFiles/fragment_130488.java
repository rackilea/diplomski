if (!sessionManagerFacebook.isLoggedIn()) {
                                sessionManagerFacebook.createLoginSession(object.getString("email"), getResources().getConfiguration().locale.toString());

                                //startActivity(new Intent(getActivity(), MainActivity.class));
                            } else {
                                user = sessionManagerFacebook.getUserDetails();
                                startActivity(new Intent(getActivity(), MainActivity.class));

                            }