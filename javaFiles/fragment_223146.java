refactor(data: string): Observable<any>{
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');

    return this.http.post(apiUrl, data,{headers,responseType: 'text'})
          .pipe(
            tap(_ => this.log('refactor')),
            catchError(this.handleError('refactor', []))
          );
}