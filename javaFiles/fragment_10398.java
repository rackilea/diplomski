list.each { item ->
    def value = item.split(" ")[0]

    if (! valuesAlreadySeen.contains(value)) {
        listUniqueValues << item
    }

    valuesAlreadySeen << value
}