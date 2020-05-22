@Override
     public View getView(int position, View convertView, ViewGroup parent) {
        int mode = getItemViewType(position);
        if(convertView == null) {   
            switch(mode){
            case 0:
                convertView = inflater.inflate(R.layout.image_container_1, parent, false);
            break;
            case 1:                  
                convertView = inflater.inflate(R.layout.image_container_2, parent, false);          
            break;
            case 2:              
                convertView = inflater.inflate(R.layout.image_container_3, parent, false);
            break;
            }   
        }
        switch (mode) {
        case 0:
                    if(i < (flowImages.size()))
            {
            ImageView imageView = (ImageView) convertView.findViewById(R.id.logo_1);

            ArrayList<ImageDimensions> dimensions = new ArrayList<ImageDimensions>();

            dimensions = ImageSorter.getLayout(1);

            // get parameters

                    // set image with url

            i++; // I don't know what you try to measure with this variable but 
            // you shouldn't do it in a method like getView as this method is called a lot of times
            // for example the user coculd be playing, scrolling the ListView one item down and one item up for 500 times.
            } 
        break;        
        case 1:
            if(i < (flowImages.size()-1))
            {
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.logo_2_1);
            ImageView imageView2 = (ImageView) convertView.findViewById(R.id.logo_2_2);

            ArrayList<ImageDimensions> dimensions = new ArrayList<ImageDimensions>();

             // get parameters for 2 images

                    // set image for first imageview    
            i++;
               // set image for second imageview
               i++;
            }

        break;       
        case 2:

            if(i < (flowImages.size()-2))
            {
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.logo_3_1);
            ImageView imageView2 = (ImageView) convertView.findViewById(R.id.logo_3_2);
            ImageView imageView3 = (ImageView) convertView.findViewById(R.id.logo_3_3);

            ArrayList<ImageDimensions> dimensions = new ArrayList<ImageDimensions>();

           // get parameters for 3 images

                    // set image with url for first imageview
            i++;
            // set image for second imageview
            i++;
        // set image for third imageview
                   i++;
            }


    break;
    }
    return convertView;

}