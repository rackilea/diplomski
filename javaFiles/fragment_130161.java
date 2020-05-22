class SOCLass {

    public static void main(String[] args){

        String[] names = new String[] {"joe", "bill"};
        String[] temp_names  = names;// new String[names.length];
        //System.arraycopy(names, 0, temp_names, 0, 2);

        for (int i = 0; i < names.length; i++)
        {
            for (int j = 0; j < names.length; j++)
            {
                String biggest = ""+(0);
                int biggest_index = 0;

                for (int chr = 0; chr < ((biggest.length() < temp_names[j].length()) ? biggest.length() : temp_names[j].length()); chr++)
                {
                    if (biggest.toCharArray()[chr] > temp_names[j].toCharArray()[chr])
                    {
                        break;
                    }
                    else if (biggest.toCharArray()[chr] < temp_names[j].toCharArray()[chr])
                    {
                        biggest = temp_names[j];
                        biggest_index = j;
                        break;
                    }
                }

                names[i] = biggest;
                temp_names[biggest_index] = ""+(255);
            }
        }

        for(String s : names)
            System.out.println(s);
        for(String s : temp_names)
            System.out.println(s);

    }

}