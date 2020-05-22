import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

    @Data
    @RequiredArgsConstructor
    @Component
    @Scope(scopeName="prototype")
    public class FooClass {

        @NonNull
        @MyAnnotation
        private String str;

        private String uninterceptedString;

    }