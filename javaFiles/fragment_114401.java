public static void main(String[] args) throws Exception
{
    CaptchaImageResource resource = new CaptchaImageResource();
    int avail = resource.getResourceStream().getInputStream().available();
    System.out.println("avail: " + avail);
}