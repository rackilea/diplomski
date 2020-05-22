discount;
total_amount = some Cost you calculated/inputted
if(total_amount > 10000) {
    discount = 0.2;
} else if(total_amount > 5000) {
    discount = 0.05;
} else if(total_amount > 2000) {
    discount = 0.01;
} else {
    discount = 0.00; // no discount for you coz total_amount less than or equal to 2000
}