constructor(interventionId: Int?, date: Date?, addressName: String?) {

      this.id = interventionId
      this.date = date

      this.address = Address()
      this.address?.name = addressName
}