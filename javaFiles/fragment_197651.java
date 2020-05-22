// Assume numbers is sorted in ascending order
// progress_so_far lists the steps we have taken to get the solution.
void search(numbers, progress_so_far, target) {    
    for each a in numbers {
        for each b in numbers after a {
            for each op in + - * / {
                if (b op a is valid) {
                    result = b op a;

                    if (result == target) {
                       // Success !
                       // Print out how we got there.
                    }
                    else if (numbers.size() > 2) {
                        new_numbers = copy of numbers with a and b removed and result added, sorted in ascending order;
                        new_progress = copy of progress_so_far with 'b op a' added;
                        search(new_numbers, new_progress, target);
                    }
                }
            }
        }
    }
}