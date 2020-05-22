db.students.update( { name: "joe" },
                    { $push: { quizzes: { $each: [ { id: 3, score: 8 },
                                                   { id: 4, score: 7 },
                                                   { id: 5, score: 6 } ],
                                          $sort: { score: 1 },
                                          $slice: -5
                                        }
                             }
                    }
                  )