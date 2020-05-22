class MyFragment extends Fragment{
    public String likeTitles[]  = {"mazda","whynot","OHYEAAAaa","ok","1983198312893"};   
    public MainFragment(String[] s1){   
        for(int i = 0; i < likeTitles.length; i++)
                s1[i] = likeTitles[i];
    }
}