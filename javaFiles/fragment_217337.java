class CustomDelegate {
    @Delegate
    LinkedHashMap map = [:]

    boolean equals(Map o) {
        false
    }

    static void main(args) {
        def customDelegate = new CustomDelegate()
        customDelegate.put('key', 'value')

        // both of these will pass...
        assert [key: 'value'] == customDelegate
        assert customDelegate != [key: 'value']
    }
}