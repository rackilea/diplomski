export class MockUserService {

   getAll() {
    return of({
        key1: 'key1',
        someList : [{ "0" : "stringValue"}]
    })
   }

}