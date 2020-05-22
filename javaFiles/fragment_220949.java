public static void main(String[] args)
{   song rock = new song(); 
    recording record = new recording(rock);
    rock.songtype();
    record.recording();
    // here song class's user value is working with rock.song1 
    System.out.println("So you are "+rock.song1+" Music lover");
}