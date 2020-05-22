public class Cycle {
/* Important! We can re-use the same scanner for all inputs. */
final Scanner in;

public Cycle() {
    in = new Scanner(System.in);
    run();
    in.close();
}

private void run() {
    System.out.println("Input mission number.");
    final int indicator = Integer.parseInt(in.nextLine());
    if (indicator == 1) {
        mission1();
    } else if (indicator == 2) {
        // etc
    }
}

private void mission1() {
    while (true) {
        System.out.println("Input number of citizens.");
        final int citizens = Integer.valueOf(in.nextLine());

        /* We don't edit these two first inputs just yet since we
         * have to use the un-edited inputs later in our if-else
         * statement. */
        System.out.println("Input first number(s).");
        final String inputOne = in.nextLine();
        System.out.println("Input second number(s).");
        final String inputTwo = in.nextLine();

        final String lines = inputOne.replaceAll("\\s", "");
        final int length = lines.length();
        final String lines2 = inputTwo.replaceAll("\\s", "");
        final int length2 = lines2.length();

        if (citizens != length || citizens != length2) {
            /* If the number of citizens doesn't match it just
             * continues the while-loop and does it all over
             * again. */
            System.out.println("Citizens number do not match, try again");
        } else {
            /* Here we use the unedited inputs from before - which
             * is why we didn't edit them. */
            final int[] dspeed = createArrayFromInput(inputOne);
            final int[] pspeed = createArrayFromInput(inputTwo);
            break;
        }
    }
}

/* We shouldn't have duplicated code - use a method instead. */
private int[] createArrayFromInput(final String input) {
    final String[] strs = input.trim().split("\\s+");
    /* The arrays should be the same size so use 'strs.length' as
     * length */
    final int[] speed = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
        speed[i] = Integer.parseInt(strs[i]);
    }
    Arrays.sort(speed);
    return speed;
}

public static void main(final String[] arg) {
    /*We should use a class instance instead of static methods and variables.*/
    new Cycle();
}
}