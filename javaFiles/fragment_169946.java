long hh = (mills / (1000 * 60 * 60));
        Mins = (int) (mills / (1000 * 60)) % 60;
        long Secs = (int) (mills / 1000) % 60;
        long timeDifDays = mills / (24 * 60 * 60 * 1000);



        if (timeDifDays >= 24) {

            int i = getContext().getContentResolver().delete(UriCalls, BaseColumns._ID+"=?", new String[]{callNumber});

            if (i >= 1)

            {

                Toast.makeText(getContext(), "Number deleted", Toast.LENGTH_SHORT).show();
            } else

            {

                Toast.makeText(getContext(), "No such number in call logs", Toast.LENGTH_SHORT).show();

            }
        }
    } catch (Exception e) {

    }
}


}