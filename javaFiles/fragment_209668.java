MatchResult matcher = regExp.exec(this.sqlFilter, "g");
    while (matcher != null) {
        ...

        matcher = regExp.exec(this.sqlFilter);
    }