class FirstScript implements Serializable{
    def firstFunction(dsl) {
        dsl.echo "This print doesn't work. well now it does. :)"
        return "This string can be returned and printed"
    }
}

return new FirstScript()