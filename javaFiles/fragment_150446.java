package testCode;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class TestClass {

    Joiner joinComma = Joiner.on(", ");
    Joiner joinAndForTwo = Joiner.on(" and ");
    Joiner joinAndForMoreThanTwo = Joiner.on(", and ");

    public String joinWithAnd(List<String> elements) {
        ImmutableList<String> elementsNoNullsOrEmpties = new ImmutableList.Builder<String>()
                .addAll(Iterables.filter(elements, new Predicate<String>() {
                    @Override
                    public boolean apply(String arg0) {
                        return !Strings.isNullOrEmpty(arg0);
                    }
                })).build();

        if (elementsNoNullsOrEmpties.size() == 0) {
            return null;
        } else if (elementsNoNullsOrEmpties.size() == 1) {
            return Iterables.getOnlyElement(elementsNoNullsOrEmpties);
        } else if (elementsNoNullsOrEmpties.size() == 2) {
            return joinAndForTwo.join(elementsNoNullsOrEmpties);
        } else {
            final List<String> leadingElements = elementsNoNullsOrEmpties
                    .subList(0, elementsNoNullsOrEmpties.size() - 1);
            final String trailingElement = elementsNoNullsOrEmpties
                    .get(elementsNoNullsOrEmpties.size() - 1);
            return joinAndForMoreThanTwo.join(joinComma.join(leadingElements),
                    trailingElement);
        }
    }
}