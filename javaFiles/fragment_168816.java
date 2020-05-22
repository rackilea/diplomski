import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David Buzatto
 */
public class ASimpleParser {

    public static void main( String[] args ) {
        new ASimpleParser().exec();
    }

    public void exec() {

        String[] in = {
            "30no31yesapproximately 278 billion miles from anything.32no33no34no",
            "30no31yesapproximately 278 billion miles from anything32no33yessince the invention of call waiting34yesGravity is a contributing factor in 73 percent of all accidents involving falling objects.",
            "35yesanybody who owns hideous clothing36yes if you take it from another person's plate37yes172 miles per hour upside down38yesonly more intelligent39yes any product including floor wax that has fat in it",
            "35no36yestake it from another person's plate37yes172 miles per hour upside down38no39no",
            "35no36no37yes172 miles per hour38no39no",
            "35no36no37yesupside down38no39no"
        };

        Pattern p = Pattern.compile( "(\\d+)(yes|no)" );
        List<Answer> allAnswers = new ArrayList<Answer>();

        for ( String s : in ) {

            List<Answer> answers = new ArrayList<Answer>();
            Matcher m = p.matcher( s );

            // step 1: detecting answer bounds (start)
            while ( m.find() ) {

                Answer a = new Answer();
                a.answerStart = m.group();
                a.number = m.group( 1 );
                a.yesOrNo = m.group( 2 );
                a.startAt = s.indexOf( a.answerStart );

                answers.add( a );

            }

            // step 2: slicing
            for ( int i = 0; i < answers.size(); i++ ) {

                Answer a = answers.get( i );

                // needs to compare to the right one, the will have the right bounds
                if ( i != answers.size() - 1 ) {

                    Answer rightAnswer = answers.get( i + 1 );
                    a.text = s.substring( a.startAt + a.answerStart.length(), rightAnswer.startAt );

                } else { // int the last answer, the right bound is the end of the main String. s.length() may be ommited.

                    a.text = s.substring( a.startAt + a.answerStart.length(), s.length() );

                }

            }

            allAnswers.addAll( answers );

        }

        // just iterating over the answers to show them.
        for ( Answer a : allAnswers ) {
            System.out.println( a );
        }

    }

    // a private class to contain the answers data
    private class Answer {

        String answerStart;
        String number;
        String yesOrNo;
        String text;
        int startAt;

        @Override
        public String toString() {
            return "Answer{" + "number=" + number + ", answer=" + yesOrNo + ", text=" + text + ", startAt=" + startAt + '}';
        }

    }

}