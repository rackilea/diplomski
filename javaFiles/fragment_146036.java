boolean flag = true;

public void toggleImage()
    {

            if (flag == true)
            {

                image.setVisibility(View.GONE);
                imageView2.setVisibility(View.VISIBLE);
             }
            else
            {
                //make the background visible
                image.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.GONE);
            }


    }