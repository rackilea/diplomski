public enum Student {

    case STUDENT_ONE
    case STUDENT_TWO

    var firstName: String {
        get {
            switch self {
            case .STUDENT_ONE:
                return "Steve"
            case .STUDENT_TWO:
                return "Tim"
            }
        }
    }

    var lastName: String {
        get {
            switch self {
            case .STUDENT_ONE:
                return "Jobs"
            case .STUDENT_TWO:
                return "Cook"
            }
        }
    }
}