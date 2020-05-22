// if you don't need the `str` anywhere else, the enum class can be shortened to this:
enum class WeightUnit { KG, LB } 

class UserData : BaseModel() {
    // ... more fields omitted for clarity
    @Exclude
    var weightUnitEnum: WeightUnit = WeightUnit.KG
    var weightUnit: String by enumStringLowerCase(UserData::weightUnitEnum)
}