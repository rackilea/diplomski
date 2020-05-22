import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;


public class Foo {
    public static void main(String[] args)
    {
        final Set<String> s1 = ImmutableSet.of("[+9, +4, +a]");
        final Set<String> s2 = ImmutableSet.of("[+i*o -k*z +(m+n+f+5)]","[+i*o +(m+n+f+5) -k*z]","[+(m+n+f+5) +i*o -k*z]");
        final Set<String> s3 = ImmutableSet.of("[+h*i/o +6*l/8]");
        final Set<String> s4 = ImmutableSet.of("[+b/c/r +(a*b*x*y+1)]","[+(a*b*x*y+1)+b/c/r]");
        @SuppressWarnings("unchecked")
        final Set<List<String>> cartesianProducts = Sets.cartesianProduct(s1, s2, s3, s4);
        for (final List<String> cartesianProduct : cartesianProducts) {
            System.out.println(Joiner.on("").join(cartesianProduct));
        }
    }        
}