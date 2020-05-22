@Override
               public void onClick(DialogInterface dialog, int which) {

               logout.getContext().startActivity(new Intent(logout.getContext(), MainActivity.class));
               Intent logout = new Intent(getActivity(),MainActivity.class);
               getActivity().startActivity(logout);
               AccountKit.logOut();
               getActivity().finish();

               preferenceHelperRistoratore.putIsLoginRistoratore(false);
               logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    }