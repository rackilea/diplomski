class Vote {
    String item
    Date dtCreated
    String user
}

class Comment {
    String item
    Date dtCreated
    String user
}

//Bootstrap
def vote1 = new Vote(item: "A", dtCreated: new Date(), user: 'user1')
def vote2 = new Vote(item: "A", dtCreated: new Date() + 1, user: 'user2')
def vote3 = new Vote(item: "A", dtCreated: new Date() + 2, user: 'user3')

def comment1 = new Comment(item: "A", dtCreated: new Date(), user: 'user4')
def comment2 = new Comment(item: "A", dtCreated: new Date() - 4, user: 'user5')
def comment3 = new Comment(item: "A", dtCreated: new Date() - 6, user: 'user6')

[vote1, vote2, vote3, comment1, comment2, comment3]*.save(flush: true, failOnError: true)

//Output Json:
[
    {
        "dtCreated": "2013-06-23T13:49:24Z",
        "user": "user3"
    },
    {
        "dtCreated": "2013-06-22T13:49:24Z",
        "user": "user2"
    },
    {
        "dtCreated": "2013-06-21T13:49:24Z",
        "user": "user4"
    },
    {
        "dtCreated": "2013-06-21T13:49:24Z",
        "user": "user1"
    },
    {
        "dtCreated": "2013-06-17T13:49:24Z",
        "user": "user5"
    },
    {
        "dtCreated": "2013-06-15T13:49:24Z",
        "user": "user6"
    }
]