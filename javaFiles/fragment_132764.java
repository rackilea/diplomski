String.metaClass.replace << { pattern, replacement, n ->
    def result = delegate
    n.times { result = result.replaceFirst pattern, replacement }
    result
}

someString.replace(/(?<=\p{L}) (?=\p{L})/, '', 3)