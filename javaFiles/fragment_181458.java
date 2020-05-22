interface EnumIdentity { }
class Status implements EnumIdentity {

    private static AllValues: { [name: string] : Status } = {};

    static readonly Active = new Status(1, "Active");
    static readonly AwaitingReview = new Status(2, "Awaiting Review");
    static readonly Closed = new Status(3, "Closed");
    static readonly Complete = new Status(4, "Complete");
    static readonly Draft = new Status(5, "Draft");
    static readonly InProcess = new Status(6, "In Process");
    static readonly InReview = new Status(7, "In Review");
    static readonly NotStarted = new Status(8, "Not Started");
    static readonly PendingResolution = new Status(9, "Pending Resolution");
    static readonly Rejected = new Status(10, "Rejected");

    private constructor(public readonly id: number, public readonly displayValue: string) {
        Status.AllValues[displayValue] = this;
    }

    public static parseEnum(data: string) : Status{
        return Status.AllValues[data];
    }

}