entity ResponseJson {
    ...
}

entity ObjectContainingString {
    name String
}

relationship OneToMany {
    ResponseJson{name} to ObjectContainingString{json}
}