public CharSequence getPageTitle(int position) {

            if (position == 0)
            {
                return "Stories";
            }
            if (position == 1)
            {
                return "Legends";
            }
            if (position == 2)
            {
                return "Multimedia";
            }
            if (position == 3)
            {
                return "Books";
            } 
            return null;
        }