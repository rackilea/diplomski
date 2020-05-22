import javaslang.control.Try;
import static javaslang.API.For;
...

For(amountTry, currencyTry)
    .yield(Amount::of)
    .forEach(sale::setAmount);