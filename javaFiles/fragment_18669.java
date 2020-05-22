/**
 *  Due to how our JSON is being provided we created an inner
 *  class. 
 **/ 
public class Answer {

    private RealAnswer answer;

    private class RealAnswer {

        public String text;
    }

    ...
}