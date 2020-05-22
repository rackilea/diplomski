@MyAnnotation
        class Super {
          @Oneway public void foo() {}
        }

        class Sub extends Super {
          public void foo() {}
        }