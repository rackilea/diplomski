db.expiring.count({
  "$where": function () {

    var now = new Date(),
        today = new Date(
          now.valueOf() -
          ( now.valueOf() % ( 1000 * 60 * 60 * 24 ) )
        );

    var adjustedMonth =
      this.contractDate.getMonth() + 1 + this.term;

    var year = ( adjustedMonth > 12 ) ?
      this.contractDate.getFullYear() + 1
      : this.contractDate.getFullYear();

    var month = ( adjustedMonth > 12 ) ?
      adjustedMonth - 12 : adjustedMonth;

    var day = this.contractDate.getDate();

    var expiring = new Date( year + "-" + month + "-" + day );
    return expiring > today;
  }
})