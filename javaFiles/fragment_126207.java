Class thisClass = new SecurityManager() {

        public Class getCurrentClass() {
            return getClassContext()[1];
        }

    }.getCurrentClass();