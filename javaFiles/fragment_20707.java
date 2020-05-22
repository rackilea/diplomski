public class YourClass
{
    private List<String> numbers;
    private ListIterator<String> litr;

    public YourClass () {
        numbers = new ArrayList<>();
        numbers.add("A");
        numbers.add("B");
        numbers.add("C");                 
        litr = numbers.listIterator();  
    }

    ... 
    btnNext.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {              
            if (litr.hasNext()) {                  
                System.out.print(litr.next());
            }
        }
    });
    ...
}