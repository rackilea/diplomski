public class QuizeRunner{

    int score = 0;
    Scanner input = new Scanner( System.in );
    QuizGenerator qg = new QuizGenerator();
    ArrayList<Question> quiz = qg.generateQuiz();

    long startTime = System.currentTimeMillis(); //fetch starting time

    //timer
    Timer timer = new Timer();
    timer.schedule( new TimerTask()
    {
        @Override
        public void run()
        {
            if ( ( System.currentTimeMillis() - startTime ) / 1000 > 10 )
            {
                System.out.println( "time out !!. score " + score );
                System.exit( 0 );
            }
        }

    }, 1000, 1000 );


    //ask questions
    for ( Question q : quiz )
    {

        System.out.println( q.getQuestion() );
        int playerAnswer = input.nextInt();
    }

    System.out.println( "You scored: " + score );
 }