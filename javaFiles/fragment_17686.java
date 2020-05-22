class User : BaseObservable() {

@get:Bindable
var firstName: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.firstName)
    }

@get:Bindable
var lastName: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.lastName)
    }
}