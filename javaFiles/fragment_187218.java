package com.github.wololock.micronaut.products

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ProductControllerSpec extends Specification {

  @Inject
  @Client("/")
  HttpClient http

  def "should return PROD-001"() {
    when:
    Product product = http.toBlocking().retrieve(HttpRequest.GET("/product/PROD-001"), Product)

    then:
    product.id == 'PROD-001'

    and:
    product.name == 'Micronaut in Action'

    and:
    product.price == 29.99
  }

  def "should support 404 response"() {
    when:
    http.toBlocking().exchange(HttpRequest.GET("/product/PROD-009"))

    then:
    def e = thrown HttpClientResponseException
    e.status == HttpStatus.NOT_FOUND
  }
}