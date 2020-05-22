public static class Source {
        private Date value;
        public void setValue(Date value) {
            this.value = value;
        }
        public Date getValue() {
            return value;
        }
    }

    public static class Target {
        private Calendar value;
        public void setValue(Calendar value) {
            this.value = value;
        }
        public Calendar getValue() {
            return value;
        }
    }


    @Test
    public void testConversion()
    {
        final GregorianCalendar cal = new GregorianCalendar(2009, 2, 3);
        Source source = new Source(){{ setValue(cal.getTime());}};

        DozerBeanMapper mapper = new DozerBeanMapper();
        Target result = (Target) mapper.map(source, Target.class);
        assertEquals(cal.getTimeInMillis(), result.getValue().getTimeInMillis());
    }